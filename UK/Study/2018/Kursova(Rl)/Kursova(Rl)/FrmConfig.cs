using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Kursova_Rl_
{
    public partial class FrmConfig : Form
    {
        public static int MinZnach;
        public static int MaxZnach;
        public static int Kil;
        public static int steep;
        public static string dia;
        public static int countForm;
        public FrmConfig()
        {
            countForm = 0;
            InitializeComponent();
        }

        private void FrmConfig_Load(object sender, EventArgs e)
        {
            MaximizeBox = false;
            countForm = 1;
        }

        private void BtnPoch_Click(object sender, EventArgs e)
        {
            if (txtBoxSteep.Text == "0")
            {
                MessageBox.Show("Крок не може дорівнювати 0");
            }
            else
            {
                if (txtBoxMin.Text != "" && txtBoxMax.Text != "" && txtBoxKil.Text != "" && txtBoxSteep.Text != "")
                {
                    MinZnach = int.Parse(txtBoxMin.Text);
                    MaxZnach = int.Parse(txtBoxMax.Text);
                    Kil = int.Parse(txtBoxKil.Text);
                    steep = int.Parse(txtBoxSteep.Text);
                    if (rbPlus.Checked)
                    {
                        dia = rbPlus.Text;
                    }
                    else if (rbMinus.Checked)
                    {
                        dia = rbMinus.Text;
                    }
                    else if (rbMnoz.Checked)
                    {
                        dia = rbMnoz.Text;
                    }
                    else if (rbDil.Checked)
                    {
                        dia = rbDil.Text;
                    }
                    if (FrmTestRandom.countForm == 0)
                    {
                        FrmTestRandom start = new FrmTestRandom();
                        start.Show();
                        this.Hide();
                    }
                }
                else
                {
                    MessageBox.Show("Не достатньо даних, повторіть спробу");
                }

            } 
        }
        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            countForm = 0;
            this.Close();
           // FrmTEMATEST start = new FrmTEMATEST();
           // start.Show();
        }

        private void FrmConfig_FormClosing(object sender, FormClosingEventArgs e)
        {
            countForm = 0;
            FrmTEMATEST start = new FrmTEMATEST();
            start.Show();
        }

        private void FrmConfig_ResizeBegin(object sender, EventArgs e)
        {
            Opacity = 0.5;
        }

        private void FrmConfig_ResizeEnd(object sender, EventArgs e)
        {
            Opacity = 1;
        }

        private void txtBoxMax_TextChanged(object sender, EventArgs e)
        {

        }

        private void txtBoxMin_KeyPress(object sender, KeyPressEventArgs e)
        {
            char number = e.KeyChar;
            if (!Char.IsDigit(number) && number != 8) // цифры и клавиша BackSpace
            {
                e.Handled = true;
            }
        }

        private void txtBoxMax_KeyPress(object sender, KeyPressEventArgs e)
        {
            char number = e.KeyChar;
            if (!Char.IsDigit(number) && number != 8) // цифры и клавиша BackSpace
            {
                e.Handled = true;
            }
        }

        private void txtBoxKil_KeyPress(object sender, KeyPressEventArgs e)
        {
            char number = e.KeyChar;
            if (!Char.IsDigit(number) && number != 8) // цифры и клавиша BackSpace
            {
                e.Handled = true;
            }
        }

        private void txtBoxSteep_KeyPress(object sender, KeyPressEventArgs e)
        {
            char number = e.KeyChar;
            if (!Char.IsDigit(number) && number != 8) // цифры и клавиша BackSpace
            {
                e.Handled = true;
            }
        }
    }
}
